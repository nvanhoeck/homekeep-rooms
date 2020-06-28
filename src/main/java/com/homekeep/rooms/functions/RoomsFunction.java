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
public class RoomsFunction extends AzureSpringBootRequestHandler<Void, List<RoomDto>> {
    /**
     * This function listens at endpoint "/api/Rooms". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Rooms
     * 2. curl {your host}/api/Rooms?name=HTTP%20Query
     */
    @FunctionName("get-rooms")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", route = "rooms", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        try {
            return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(context)).build();
        } catch (Exception e) {
            context.getLogger().log(Level.ALL, e.toString());
           return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()).build();
        }
    }
}
