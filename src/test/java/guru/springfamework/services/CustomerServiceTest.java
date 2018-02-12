package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    public static final long ID = 1L;
    public static final String NAME = "John";

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getCustomerById() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(NAME);

        Optional<Customer> optionalCustomer = Optional.of(customer);

        when(customerRepository.findById(anyLong())).thenReturn(optionalCustomer);

        //when
        CustomerDTO customerById = customerService.getCustomerById(ID);

        //then
        assertEquals(Long.valueOf(1), customerById.getId());
        assertEquals(NAME, customerById.getFirstname());
    }

    @Test
    public void getAllCustomers() {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customersDTO = customerService.getAllCustomers();

        //then
        assertEquals(2, customersDTO.size());

    }
}