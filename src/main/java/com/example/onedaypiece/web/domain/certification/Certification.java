package com.example.onedaypiece.web.domain.certification;


import com.example.onedaypiece.web.domain.member.Member;
import com.example.onedaypiece.web.domain.point.Point;
import com.example.onedaypiece.web.domain.posting.Posting;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Certification {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long certificationId;

    @ManyToOne
    private Posting posting;

    @ManyToOne
    private Member member;

    //포인트는 디비상에만 존재하는거
//    @ManyToOne
//    private Point point;

}
