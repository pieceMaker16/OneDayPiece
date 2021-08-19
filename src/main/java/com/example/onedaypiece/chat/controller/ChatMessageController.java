package com.example.onedaypiece.chat.controller;

import com.example.onedaypiece.chat.dto.request.ChatMessageRequestDto;
import com.example.onedaypiece.chat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    // 웹소켓으로 들어오는 메시지 발행 처리 -> 클라이언트에서는 /pub/message로 발행 요청
    @MessageMapping("/message")
    public ResponseEntity<Void> pubMessage(@RequestBody ChatMessageRequestDto requestDto) {
        chatMessageService.sendChatMessage(requestDto);
        return ResponseEntity.ok().build();
    }

}
