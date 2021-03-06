package com.example.onedaypiece.web.controller;

import com.example.onedaypiece.service.ChallengeRecordService;
import com.example.onedaypiece.web.dto.request.challengeRecord.ChallengeRecordRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChallengeRecordController {

    private final ChallengeRecordService challengeRecordService;

    /**
     * 1. 챌린지 신청
     */
    @PostMapping("/api/member/challenge-request")
    public void requestChallenge(@RequestBody ChallengeRecordRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetails userDetails) {
        log.info("POST challengeRecord / challenge id : {} by {}",
                requestDto.getChallengeId(), userDetails.getUsername());
        challengeRecordService.requestChallenge(requestDto, userDetails.getUsername());
    }

    /**
     * 2. 챌린지 포기
     */
    @DeleteMapping("/api/member/challenge-give-up/{challengeId}")
    public void giveUpChallenge(@PathVariable Long challengeId,
                                @AuthenticationPrincipal UserDetails userDetails) {
        log.info("DELETE challengeRecord / challenge id : {} by {} ",
                challengeId, userDetails.getUsername());
        challengeRecordService.giveUpChallenge(challengeId, userDetails.getUsername());
    }
}