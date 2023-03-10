/*
 * Selling Partner API for Orders
 * The Selling Partner API for Orders helps you programmatically retrieve order information. These APIs let you develop fast, flexible, custom applications in areas like order synchronization, order research, and demand-based decision support tools.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.GetOrderApprovalsResponse;
import io.swagger.client.model.ItemApprovalStatus;
import io.swagger.client.model.ItemApprovalType;
import io.swagger.client.model.UpdateItemsApprovalsErrorResponse;
import io.swagger.client.model.UpdateOrderApprovalsRequest;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApprovalsApi
 */
@Ignore
public class ApprovalsApiTest {

    private final ApprovalsApi api = new ApprovalsApi();

    
    /**
     * 
     *
     * Returns detailed order items approvals information for the order specified. If NextToken is provided, it&#39;s used to retrieve the next page of order items approvals.  **Usage Plans:**  | Plan type | Rate (requests per second) | Burst | | ---- | ---- | ---- | |Default| 0.5 | 30 | |Selling partner specific| Variable | Variable |  The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see \&quot;Usage Plans and Rate Limits\&quot; in the Selling Partner API documentation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getOrderItemsApprovalsTest() throws ApiException {
        String orderId = null;
        String nextToken = null;
        List<ItemApprovalType> itemApprovalTypes = null;
        List<ItemApprovalStatus> itemApprovalStatus = null;
        GetOrderApprovalsResponse response = api.getOrderItemsApprovals(orderId, nextToken, itemApprovalTypes, itemApprovalStatus);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Update the order items approvals for an order that you specify.  **Usage Plan:**  | Rate (requests per second) | Burst | | ---- | ---- | | 5 | 15 |  The &#x60;x-amzn-RateLimit-Limit&#x60; response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](doc:usage-plans-and-rate-limits-in-the-sp-api).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateOrderItemsApprovalsTest() throws ApiException {
        String orderId = null;
        UpdateOrderApprovalsRequest payload = null;
        api.updateOrderItemsApprovals(orderId, payload);

        // TODO: test validations
    }
    
}
