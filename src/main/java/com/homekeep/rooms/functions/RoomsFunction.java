package com.homekeep.rooms.functions;

import java.util.*;

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
    @FunctionName("rooms")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(context)).build();
    }
}
