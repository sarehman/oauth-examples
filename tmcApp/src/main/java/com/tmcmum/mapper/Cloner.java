package com.tmcmum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import com.tmcmum.model.Student;
import com.tmcmum.model.User;

/**
 * @author Sjaak Derksen
 *
 * By defining all methods, we force MapStruct to generate new objects for each mapper in stead of
 * taking shortcuts by mapping an object directly.
 */
@Mapper(mappingControl = DeepClone.class)
public interface Cloner {

    Cloner MAPPER = Mappers.getMapper( Cloner.class );

    Student clone(Student studentObj);
    User clone(User userObj);
}
   