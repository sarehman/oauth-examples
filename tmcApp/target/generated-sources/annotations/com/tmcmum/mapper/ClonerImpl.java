package com.tmcmum.mapper;

import com.tmcmum.model.AuthProvider;
import com.tmcmum.model.Student;
import com.tmcmum.model.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T23:48:43+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_342-342 (OpenLogic-OpenJDK)"
)
public class ClonerImpl implements Cloner {

    @Override
    public Student clone(Student studentObj) {
        if ( studentObj == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentObj.getId() );
        student.setName( studentObj.getName() );
        student.setGrNo( studentObj.getGrNo() );
        student.setMotherName( studentObj.getMotherName() );
        student.setUid( studentObj.getUid() );
        student.setNationality( studentObj.getNationality() );
        student.setMotherTongue( studentObj.getMotherTongue() );
        student.setReligion( studentObj.getReligion() );
        student.setCaste( studentObj.getCaste() );
        student.setSubCaste( studentObj.getSubCaste() );
        student.setBirthPlace( studentObj.getBirthPlace() );
        student.setTaluka( studentObj.getTaluka() );
        student.setDistrict( studentObj.getDistrict() );
        student.setState( studentObj.getState() );
        student.setCountry( studentObj.getCountry() );
        student.setDob( studentObj.getDob() );
        student.setDob_letters( studentObj.getDob_letters() );
        student.setPreviousSchool( studentObj.getPreviousSchool() );
        student.setStandard( studentObj.getStandard() );
        student.setDateAdmission( studentObj.getDateAdmission() );
        student.setStudyProgress( studentObj.getStudyProgress() );
        student.setDateOfLeaving( studentObj.getDateOfLeaving() );
        student.setStandardAtLeaving( studentObj.getStandardAtLeaving() );
        student.setReasonOfLeaving( studentObj.getReasonOfLeaving() );

        return student;
    }

    @Override
    public User clone(User userObj) {
        if ( userObj == null ) {
            return null;
        }

        User user = new User();

        user.setId( userObj.getId() );
        user.setName( userObj.getName() );
        user.setEmail( userObj.getEmail() );
        user.setImageUrl( userObj.getImageUrl() );
        user.setEmailVerified( userObj.isEmailVerified() );
        user.setPassword( userObj.getPassword() );
        user.setProvider( authProviderToAuthProvider( userObj.getProvider() ) );
        user.setProviderId( userObj.getProviderId() );

        return user;
    }

    protected AuthProvider authProviderToAuthProvider(AuthProvider authProvider) {
        if ( authProvider == null ) {
            return null;
        }

        AuthProvider authProvider1;

        switch ( authProvider ) {
            case google: authProvider1 = AuthProvider.google;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + authProvider );
        }

        return authProvider1;
    }
}
