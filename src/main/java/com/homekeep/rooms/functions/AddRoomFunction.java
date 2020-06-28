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
public class AddRoomFunction extends AzureSpringBootRequestHandler<RoomDto, RoomDto> {
    /**
     * This function listens at endpoint "/api/add-room". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/add-room
     * 2. curl {your host}/api/Add-room?name=HTTP%20Query
     */
    @FunctionName("add-room")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", route = "rooms", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<RoomDto> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        try {
            return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(request.getBody(), context)).build();
        } catch (Exception e) {
            context.getLogger().log(Level.ALL, e.toString());
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()).build();
        }
    }
}
