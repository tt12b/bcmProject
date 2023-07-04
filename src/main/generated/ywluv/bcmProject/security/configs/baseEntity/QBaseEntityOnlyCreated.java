package ywluv.bcmProject.security.configs.baseEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntityOnlyCreated is a Querydsl query type for BaseEntityOnlyCreated
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntityOnlyCreated extends EntityPathBase<BaseEntityOnlyCreated> {

    private static final long serialVersionUID = 2077715735L;

    public static final QBaseEntityOnlyCreated baseEntityOnlyCreated = new QBaseEntityOnlyCreated("baseEntityOnlyCreated");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public QBaseEntityOnlyCreated(String variable) {
        super(BaseEntityOnlyCreated.class, forVariable(variable));
    }

    public QBaseEntityOnlyCreated(Path<? extends BaseEntityOnlyCreated> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntityOnlyCreated(PathMetadata metadata) {
        super(BaseEntityOnlyCreated.class, metadata);
    }

}

