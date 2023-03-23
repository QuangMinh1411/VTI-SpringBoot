package vn.techmaster.customerinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.techmaster.customerinfo.model.Customer;
import vn.techmaster.customerinfo.model.CustomerPoJo;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerPoJo customerToPojo(Customer customer);
    Customer pojoToCustomer(CustomerPoJo poJo);
}
