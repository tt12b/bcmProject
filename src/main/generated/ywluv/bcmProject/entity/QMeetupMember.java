package ywluv.bcmProject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeetupMember is a Querydsl query type for MeetupMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeetupMember extends EntityPathBase<MeetupMember> {

    private static final long serialVersionUID = 671238661L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeetupMember meetupMember = new QMeetupMember("meetupMember");

    public final ywluv.bcmProject.security.configs.baseEntity.QBaseEntity _super = new ywluv.bcmProject.security.configs.baseEntity.QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final StringPath delete = _super.delete;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QMeetup meetup;

    public final QMember member;

    public QMeetupMember(String variable) {
        this(MeetupMember.class, forVariable(variable), INITS);
    }

    public QMeetupMember(Path<? extends MeetupMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeetupMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeetupMember(PathMetadata metadata, PathInits inits) {
        this(MeetupMember.class, metadata, inits);
    }

    public QMeetupMember(Class<? extends MeetupMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meetup = inits.isInitialized("meetup") ? new QMeetup(forProperty("meetup"), inits.get("meetup")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

