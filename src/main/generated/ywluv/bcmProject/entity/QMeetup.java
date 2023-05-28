package ywluv.bcmProject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeetup is a Querydsl query type for Meetup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeetup extends EntityPathBase<Meetup> {

    private static final long serialVersionUID = -1021188213L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeetup meetup = new QMeetup("meetup");

    public final ywluv.bcmProject.entity.baseEntity.QBaseEntity _super = new ywluv.bcmProject.entity.baseEntity.QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QMember meetingHost;

    public final DateTimePath<java.time.LocalDateTime> meetupDateTime = createDateTime("meetupDateTime", java.time.LocalDateTime.class);

    public final ListPath<MeetupMember, QMeetupMember> meetupMembers = this.<MeetupMember, QMeetupMember>createList("meetupMembers", MeetupMember.class, QMeetupMember.class, PathInits.DIRECT2);

    public final StringPath meetupName = createString("meetupName");

    public final StringPath meetupNotes = createString("meetupNotes");

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
        this.meetingHost = inits.isInitialized("meetingHost") ? new QMember(forProperty("meetingHost")) : null;
    }

}

