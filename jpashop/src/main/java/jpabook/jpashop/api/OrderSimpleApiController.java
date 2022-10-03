package jpabook.jpashop.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.OrderSimpleQueryDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * xToOne(ManyToOne, OneToOne)
 *
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
	
	private final OrderRepository orderRepository;
	private final EntityManager em;
	
	@GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); //Lazy 강제 초기화
            order.getDelivery().getAddress(); //Lazy 강제 초기화
        }
        return all;
    }
	
	@GetMapping("/api/v2/simple-orders")
	public List<OrderSimpleQueryDto> ordersV2(){
		
		//ORDER 2개
		//N(2개) + 1 문제 발생
		List<Order> orders = orderRepository.findAllByString(new OrderSearch());
		
		List<OrderSimpleQueryDto> result = orders.stream()
			.map(o -> new OrderSimpleQueryDto(o))
			.collect(Collectors.toList());
		
		return result;
	}
	
	@GetMapping("/api/v3/simple-orders")
	public List<OrderSimpleQueryDto> ordersV3(){
		
		List<Order> orders = orderRepository.findAllWithMemberDelivery();
		List<OrderSimpleQueryDto> result = orders.stream()
			.map(o -> new OrderSimpleQueryDto(o))
			.collect(Collectors.toList());
		
		
		return result;
		
	}
	@GetMapping("/api/v4/simple-orders")
	public List<OrderSimpleQueryDto> ordersV4(){
		
		return orderRepository.findOrderDtos();
		
	}
	
	
	//한 번에 모든 객체의 값을 채워서 리턴 = fetch join
	public List<Order> findAllWithMemberDelivery(){
		return em.createQuery("select o from Order o" +
				" join fetch o.member m" +
				" join fetch o.delivery d", Order.class
				).getResultList();
	}
	
	
}
