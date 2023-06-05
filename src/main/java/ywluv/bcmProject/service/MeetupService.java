package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.repository.meetup.MeetupRepository;

import java.util.ArrayList;

@Service
@Transactional(readOnly = true)
public class MeetupService {

    @Autowired MeetupRepository meetupRepository;
    @Autowired MemberService memberService;

    @Transactional(readOnly = false)
    public Long makeMeetup(Meetup meetup){

        return meetupRepository.save(meetup).getId();
    }

    @Transactional(readOnly = false)
    public Long makeMeetup(MeetupDto meetupDto){
        Meetup meetup = dtoToEntity(meetupDto);
        return meetupRepository.save(meetup).getId();
    }


    public MeetupDto findById(Long id){
        return meetupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("모임을 찾을 수 없습니다. :" + id))
                .toDto();
    }

    private Meetup dtoToEntity(MeetupDto meetupDto){

        Meetup meetup = new Meetup(
            meetupDto.getGroupId()
        ,   meetupDto.getMeetupTitle()
        ,   meetupDto.getStartDate()
        ,   meetupDto.getEndDate()
        ,   meetupDto.getAllDayYN()
        ,   meetupDto.getHostId() == null ? memberService.findById(1L) : memberService.findById(meetupDto.getHostId())
        ,   MeetupType.valueOf(meetupDto.getMeetupType())
        ,   meetupDto.getMemo()
        ,   new ArrayList<>()
        );

        return meetup;
    }

}