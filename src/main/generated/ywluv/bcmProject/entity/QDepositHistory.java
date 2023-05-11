package ywluv.bcmProject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepositHistory is a Querydsl query type for DepositHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepositHistory extends EntityPathBase<DepositHistory> {

    private static final long serialVersionUID = -2065655425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepositHistory depositHistory = new QDepositHistory("depositHistory");

    public final ywluv.bcmProject.entity.baseEntity.QBaseEntityOnlyCreated _super = new ywluv.bcmProject.entity.baseEntity.QBaseEntityOnlyCreated(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QDeposit deposit;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

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
        this.deposit = inits.isInitialized("deposit") ? new QDeposit(forProperty("deposit"), inits.get("deposit")) : null;
    }

}

