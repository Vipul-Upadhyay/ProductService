package com.productservice.controllers;

import com.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Captor
    private ArgumentCaptor<Long> argumentCaptor;
//    @Test
//    void testGetProductByIdMocking() throws ProductNotFoundException {
//    when(productService.getProductById(100L)).thenReturn(null);
//    assertNull(productController.getProductById(100L));
//    }

//    @Test
//    @DisplayName("testproductControllerCallsProductServiceWithSameProductIdAsInput")
//    void testIfSameInput() throws ProductNotFoundException {
//        Long id = 100L;
//        when(productController.getProductById(id)).thenReturn(new GenericProductDto());
//        GenericProductDto genericProductDto = productController.getProductById(id);
//        verify(productService).getProductById( argumentCaptor.capture());
//        assertEquals(id, argumentCaptor.getValue());
//    }
}
