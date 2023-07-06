package ywluv.bcmProject.repository.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.MeetupMember;


/**
 * QMeetup is a Querydsl query type for Meetup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeetup extends EntityPathBase<Meetup> {

    private static final long serialVersionUID = -1021188213L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeetup meetup = new QMeetup("meetup");

    public final ywluv.bcmProject.security.configs.baseEntity.QBaseEntity _super = new ywluv.bcmProject.security.configs.baseEntity.QBaseEntity(this);

    public final StringPath allDayYN = createString("allDayYN");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final StringPath delete = _super.delete;

    public final NumberPath<Long> groupId = createNumber("groupId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final DateTimePath<java.time.LocalDateTime> meetupEndDate = createDateTime("meetupEndDate", java.time.LocalDateTime.class);

    public final QMember meetupHost;

    public final ListPath<MeetupMember, QMeetupMember> meetupMembers = this.<MeetupMember, QMeetupMember>createList("meetupMembers", MeetupMember.class, QMeetupMember.class, PathInits.DIRECT2);

    public final StringPath meetupMemo = createString("meetupMemo");

    public final DateTimePath<java.time.LocalDateTime> meetupStartDate = createDateTime("meetupStartDate", java.time.LocalDateTime.class);

    public final StringPath meetupTitle = createString("meetupTitle");

    public final EnumPath<ywluv.bcmProject.entity.enumEntity.MeetupType> meetupType = createEnum("meetupType", ywluv.bcmProject.entity.enumEntity.MeetupType.class);

    public QMeetup(String variable) {
        this(Meetup.class, forVariable(variable), INITS);
    }

    public QMeetup(Path<? extends Meetup> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeetup(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeetup(PathMetadata metadata, PathInits inits) {
        this(Meetup.class, metadata, inits);
    }

    public QMeetup(Class<? extends Meetup> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meetupHost = inits.isInitialized("meetupHost") ? new QMember(forProperty("meetupHost")) : null;
    }

}

