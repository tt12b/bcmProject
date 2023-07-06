package ywluv.bcmProject.repository.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import ywluv.bcmProject.entity.DepositHistory;


/**
 * QDepositHistory is a Querydsl query type for DepositHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepositHistory extends EntityPathBase<DepositHistory> {

    private static final long serialVersionUID = -2065655425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepositHistory depositHistory = new QDepositHistory("depositHistory");

    public final ywluv.bcmProject.security.configs.baseEntity.QBaseEntityOnlyCreated _super = new ywluv.bcmProject.security.configs.baseEntity.QBaseEntityOnlyCreated(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath reason = createString("reason");

    public QDepositHistory(String variable) {
        this(DepositHistory.class, forVariable(variable), INITS);
    }

    public QDepositHistory(Path<? extends DepositHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepositHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepositHistory(PathMetadata metadata, PathInits inits) {
        this(DepositHistory.class, metadata, inits);
    }

    public QDepositHistory(Class<? extends DepositHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

