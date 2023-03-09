package mainsrc;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import io.swagger.client.ApiException;
import io.swagger.client.api.OrdersV0Api;
import io.swagger.client.model.GetOrdersResponse;
import io.swagger.client.model.Order;
import io.swagger.client.model.OrderList;
import io.swagger.client.model.PaymentMethodDetailItemList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static mainsrc.MarketPlaceScrapper.scrapeMarketplaceIds;
import static mainsrc.SheetsQuickstart.getCredentials;

public class MainClass {
    public static void main(String[] args) throws Exception {
        // Set up credentials
        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                .accessKeyId("Add your here")
                .secretKey("Add your here")
                .region("eu-west-1")
                .build();

        AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider = AWSAuthenticationCredentialsProvider.builder()
                .roleArn("Add your here")
                .roleSessionName(UUID.randomUUID().toString())
                .build();

        String clientIdentifier = "Add your here";
        String clientSecret = "Add your here";
        String refreshToken = "Add your here";
        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                .clientId(clientIdentifier)
                .clientSecret(clientSecret)
                .refreshToken(refreshToken)
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();

        // Create OrdersV0Api instance
        OrdersV0Api ordersApi = new OrdersV0Api.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
                .endpoint("https://sellingpartnerapi-eu.amazon.com") // Change this to the endpoint for your region
                .build();


        String url = "https://developer-docs.amazon.com/sp-api/docs/marketplace-ids";
        List<String> marketplaceIds = scrapeMarketplaceIds(url);

        try {

            String nextToken = null;
            List<List<Object>> allValues = new ArrayList<>();

            do {
                // Send request with current next token
                GetOrdersResponse ordersWithHttpInfo = ordersApi.getOrders(marketplaceIds, "2020-01-01T12:15:08Z", null, null, null, null, null, null, null, null, null, null, null,nextToken, null, null, null, null, null,null);
                OrderList orders = ordersWithHttpInfo.getPayload().getOrders();
                nextToken = ordersWithHttpInfo.getPayload().getNextToken();

                // Extract values from current page of results
                List<List<Object>> pageValues = new ArrayList<>();
                for (Order order : orders) {
                    List<Object> rowData = new ArrayList<Object>();
                    rowData.add(order.getAmazonOrderId());
                    rowData.add(order.getSellerOrderId());
                    rowData.add(order.getPurchaseDate());
                    rowData.add(order.getLastUpdateDate());
                    rowData.add(order.getOrderStatus().toString());
                    rowData.add(order.getFulfillmentChannel().toString());
                    rowData.add(order.getSalesChannel());
                    String buyerEmail = order.getBuyerInfo().getBuyerEmail();
                    if(buyerEmail==null)
                    {
                        rowData.add("null");
                    }

                    rowData.add(buyerEmail);
                  //  String paymentMethodDetailsString = "";
                    PaymentMethodDetailItemList paymentMethodDetails = order.getPaymentMethodDetails();

                    if (paymentMethodDetails == null) {
                        rowData.add("null");
                    } else {
                        StringBuilder paymentMethodDetailsBuilder = new StringBuilder();
                        for (String ps : paymentMethodDetails) {
                            paymentMethodDetailsBuilder.append(ps).append(",");
                        }
                        String paymentMethodDetailsStr = paymentMethodDetailsBuilder.toString();
                        if (paymentMethodDetailsStr.endsWith(",")) {
                            paymentMethodDetailsStr = paymentMethodDetailsStr.substring(0, paymentMethodDetailsStr.length() - 1);
                        }
                        rowData.add(paymentMethodDetailsStr);

                    }
                    rowData.add(order.getNumberOfItemsShipped());
                    rowData.add(order.getNumberOfItemsUnshipped());
                    rowData.add(order.getEarliestShipDate());
                    rowData.add(order.getLatestShipDate());
                    rowData.add(order.getOrderType().name());
                    rowData.add(order.getShipServiceLevel());
                    if(!(order.getOrderTotal()==null)) {
                        rowData.add(order.getOrderTotal().getAmount());

                    }
                    else {
                        rowData.add("null");
                    }
                    if(!(order.getOrderTotal()==null)) {

                        rowData.add(order.getOrderTotal().getCurrencyCode());
                    }
                    else {
                        rowData.add("null");
                    }
                    if(!(order.getShippingAddress()==null)) {
                       rowData.add( order.getShippingAddress().getCity());
                    }
                    else
                    {
                        rowData.add("null");
                    }
                    if(!(order.getShippingAddress()==null)) {
                        rowData.add( order.getShippingAddress().getCounty());
                    }
                    else
                    {
                        rowData.add("null");
                    }





                    //rowData.add(paymentMethodDetailsString);
                    pageValues.add(rowData);
                }

                // Add current page values to all values
                allValues.addAll(pageValues);
            } while (nextToken != null);
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Sheets service = getCredentials(HTTP_TRANSPORT);
            String spreadsheetId = "1rnlBLWZex_LZfBHGTcZov8Qt20KK39L79zgvH3mFc6c";
// Add header row to beginning of all values

            List<Object> headerRow = new ArrayList<Object>(Arrays.asList("amazonOrderId", "sellerOrderId", "purchaseDate", "lastUpdateDate", "orderStatus", "fulfillmentChannel", "salesChannel","buyerEmail","paymentMethodDetails","numberOfItemsShipped","numberOfItemsUnshipped","earliestShipDate","latestShipDate","orderType","shipServiceLevel","amount","currencyCode","city","county"));
            allValues.add(0, headerRow);

// Add all values to sheet
            ValueRange body = new ValueRange().setValues(allValues);
            UpdateValuesResponse result = service.spreadsheets().values()
                    .update(spreadsheetId, "Sheet1", body)
                    .setValueInputOption("RAW")
                    .execute();




        } catch (ApiException e) {
            System.err.println("Error fetching orders: " + e.getMessage());
            System.exit(1);
        }
    }
}