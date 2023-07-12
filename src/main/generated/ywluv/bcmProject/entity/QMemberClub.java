package ywluv.bcmProject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberClub is a Querydsl query type for MemberClub
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberClub extends EntityPathBase<MemberClub> {

    private static final long serialVersionUID = 1967465561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberClub memberClub = new QMemberClub("memberClub");

    public final ywluv.bcmProject.entity.baseEntity.QBaseEntity _super = new ywluv.bcmProject.entity.baseEntity.QBaseEntity(this);

    public final QClub club;

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

    public final QMember member;

    public QMemberClub(String variable) {
        this(MemberClub.class, forVariable(variable), INITS);
    }

    public QMemberClub(Path<? extends MemberClub> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberClub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberClub(PathMetadata metadata, PathInits inits) {
        this(MemberClub.class, metadata, inits);
    }

    public QMemberClub(Class<? extends MemberClub> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new QClub(forProperty("club")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

