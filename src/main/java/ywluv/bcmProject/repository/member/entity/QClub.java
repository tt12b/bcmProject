package ywluv.bcmProject.repository.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.MemberClub;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = -560011937L;

    public static final QClub club = new QClub("club");

    public final ywluv.bcmProject.security.configs.baseEntity.QBaseEntity _super = new ywluv.bcmProject.security.configs.baseEntity.QBaseEntity(this);

    public final StringPath clubName = createString("clubName");

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

    public final ListPath<MemberClub, QMemberClub> memberClubs = this.<MemberClub, QMemberClub>createList("memberClubs", MemberClub.class, QMemberClub.class, PathInits.DIRECT2);

    public QClub(String variable) {
        super(Club.class, forVariable(variable));
    }

    public QClub(Path<? extends Club> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClub(PathMetadata metadata) {
        super(Club.class, metadata);
    }

}

