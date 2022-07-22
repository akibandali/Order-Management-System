/*
package com.Order.tracker.Order;

import com.order.management.authoring.OrderRequestDTO;
import com.order.management.authoring.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    public static final String Order_ID = "Test-1000";
    @Mock
    private OrderRepository OrderRepository;
    @InjectMocks
    private OrderService OrderService;

    @Test
    public void testGetOrderById () {
        OrderRequestDTO testOrder=getTestOrder();
        testOrder.setId(Order_ID);
        when(OrderRepository.getById(Order_ID)).thenReturn(testOrder);
        OrderRequestDTO actual = OrderService.getOrderById(Order_ID);
        assertThat(actual.getId()).isEqualTo(Order_ID);
    }

    @Test
    public void testCreateNewOrder () {
        doNothing().when(OrderRepository).saveOrder(any());
        OrderRequestDTO testOrder=getTestOrder();
        String actual = OrderService.createNewOrder(testOrder);
        assertThat(actual).isNotNull();
        assertThat(actual).isNotEqualTo(testOrder.getId());
    }

    private OrderRequestDTO getTestOrder () {
        return OrderRequestDTO.builder().application("Search").status("Open").severity("High").title("Search not working").build();
    }
}
*/
