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
public class DeleteRoomFunction extends AzureSpringBootRequestHandler<Long, Boolean> {
    /**
     * This function listens at endpoint "/api/Delete-room". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Delete-room
     * 2. curl {your host}/api/Delete-room?name=HTTP%20Query
     */
    @FunctionName("delete-room")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", route = "rooms/{id:int}", methods = {HttpMethod.DELETE}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") int id,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        try {
            return request.createResponseBuilder(HttpStatus.OK).body(String.valueOf(handleRequest((long) id, context))).build();
        } catch (Exception e) {
            context.getLogger().log(Level.ALL, e.toString());
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()).build();
        }
    }
}
