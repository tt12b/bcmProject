package ywluv.bcmProject.entity.embedded;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QContactInfo is a Querydsl query type for ContactInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QContactInfo extends BeanPath<ContactInfo> {

    private static final long serialVersionUID = -139427341L;

    public static final QContactInfo contactInfo = new QContactInfo("contactInfo");

    public final StringPath email = createString("email");

    public final StringPath phoneNumber = createString("phoneNumber");

    public QContactInfo(String variable) {
        super(ContactInfo.class, forVariable(variable));
    }

    public QContactInfo(Path<? extends ContactInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContactInfo(PathMetadata metadata) {
        super(ContactInfo.class, metadata);
    }

}

