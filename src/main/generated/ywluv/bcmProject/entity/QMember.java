package ywluv.bcmProject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1020967677L;

    public static final QMember member = new QMember("member1");

    public final ywluv.bcmProject.entity.baseEntity.QBaseEntity _super = new ywluv.bcmProject.entity.baseEntity.QBaseEntity(this);

    public final EnumPath<ywluv.bcmProject.entity.enumEntity.AddressType> addressType = createEnum("addressType", ywluv.bcmProject.entity.enumEntity.AddressType.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final StringPath delete = _super.delete;

    public final NumberPath<Integer> deposit = createNumber("deposit", Integer.class);

    public final ListPath<DepositHistory, QDepositHistory> depositHistories = this.<DepositHistory, QDepositHistory>createList("depositHistories", DepositHistory.class, QDepositHistory.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final ListPath<Meetup, QMeetup> meetupHosts = this.<Meetup, QMeetup>createList("meetupHosts", Meetup.class, QMeetup.class, PathInits.DIRECT2);

    public final ListPath<MeetupMember, QMeetupMember> MeetupMembers = this.<MeetupMember, QMeetupMember>createList("MeetupMembers", MeetupMember.class, QMeetupMember.class, PathInits.DIRECT2);

    public final ListPath<MemberClub, QMemberClub> memberClubs = this.<MemberClub, QMemberClub>createList("memberClubs", MemberClub.class, QMemberClub.class, PathInits.DIRECT2);

    public final StringPath userName = createString("userName");

    public final StringPath userNickName = createString("userNickName");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

