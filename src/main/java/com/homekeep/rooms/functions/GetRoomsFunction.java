package com.homekeep.rooms.functions;

import java.util.*;
import java.util.logging.Level;

import com.homekeep.rooms.dtos.RoomDto;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

/**
 * Azure Functions with HTTP Trigger.
 */
public class GetRoomsFunction extends AzureSpringBootRequestHandler<Optional<?>, List<RoomDto>> {
    @FunctionName("get-all-rooms")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", route = "rooms", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Void> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        try {
            return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(Optional.empty(), context)).build();
        } catch (Exception e) {
            context.getLogger().log(Level.ALL, e.toString());
           return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()).build();
        }
    }
}
