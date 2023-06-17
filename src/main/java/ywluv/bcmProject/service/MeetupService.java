package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.repository.meetup.MeetupRepository;
import ywluv.bcmProject.util.DateUtil;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ywluv.bcmProject.util.DateUtil.StringTOLastMomentOfDay;
import static ywluv.bcmProject.util.DateUtil.StringToLocalDateTime;

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

    public Meetup findById(Long id){
        return meetupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("모임을 찾을 수 없습니다. :" + id));

    }

    public List<MeetupDto> findDailyMeetup(String initialDate){

        ArrayList<Long> groupIdList = new ArrayList<>();
        groupIdList.add(9999L);
        LocalDateTime paramFrom = StringToLocalDateTime(initialDate);
        LocalDateTime paramTo = StringTOLastMomentOfDay(initialDate);

        return meetupRepository.findMeetupsByDateBetween(paramFrom,paramTo,groupIdList);
    }

    public List<MeetupDto> findAllMeetups(String initialDate,List<Long> groupIdList){
        if(initialDate == null ) {
            initialDate = DateUtil.getCurrentDate().toString();
        }

        //그룹아이디가 비어있으면 강제로 넣는다.
        //@Query 메소드, 쿼리에서 null이거나 empty일 경우 처리하였는데 오류가 나서 임의로 값을 집어넣음
        //추후 QueryDsl로 수정하여 값이 없으면 조건이 없도록 수정
        if(groupIdList == null ) {
            groupIdList =  new ArrayList<>();
            groupIdList.add(9999L);
        }

        //기준일 31일 전후로 가져온다.
        String from = DateUtil.manipulateDate(initialDate, -31);
        String to = DateUtil.manipulateDate(initialDate,+31);

        LocalDateTime paramFrom = LocalDateTime.parse(from+"T00:00:00");
        LocalDateTime paramTo = LocalDateTime.parse(to+"T00:00:00");

        return meetupRepository.findMeetupsByDateBetween(paramFrom,paramTo,groupIdList);
    }


    private Meetup dtoToEntity(MeetupDto meetupDto){

        Meetup meetup = new Meetup(
            meetupDto.getId()
        ,   meetupDto.getGroupId()
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