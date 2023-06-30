package ywluv.bcmProject.security;

import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomSessionRegistry extends SessionRegistryImpl {
    //기본구현체 사용
}
