package com.homekeep.rooms.functions;

import com.homekeep.rooms.dtos.RoomDto;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.List;

public class GetRoomsFunction extends AzureSpringBootRequestHandler<Void, List<RoomDto>> {

    @FunctionName("rooms")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", route = "rooms", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Void> request,
            ExecutionContext context) {

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(context))
                .header("Content-Type", "application/json")
                .build();
    }
}
