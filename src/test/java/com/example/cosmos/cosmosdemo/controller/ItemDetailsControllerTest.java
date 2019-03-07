package com.example.cosmos.cosmosdemo.controller;

import com.example.cosmos.cosmosdemo.dao.ItemDetailsDao;
import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.service.ItemDetailsService;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by Nisum on 07-03-2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemDetailsController.class,secure = false)
public class ItemDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemDetailsService itemDetailsService;

    @MockBean
    ItemDetailsDao itemDetailsDao;

    @Test
    public void getItemDetailsTest() throws Exception {

        Optional<ItemDetails> optional = Optional.of(buildItemDetails());
        String expectedJson = "{'id': 1,'name': 'OnePlus6T';'description': 'One plus 6T mobile'}";
        Mockito.when(itemDetailsService.getItemDetails(Mockito.anyInt())).thenReturn(optional);

        given(itemDetailsService.getItemDetails(1)).willReturn(optional);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cosomos/items/1").contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(content().json(expectedJson))
                .andReturn();
        JSONAssert.assertEquals(expectedJson,mvcResult.getResponse().getContentAsString(),false);
    }

    @Test
    public void saveItemDetailsTest() throws Exception {
        Item item = buildItem();
        String expectedJson = "{'id': 1,'name': 'OnePlus6T';'description': 'One plus 6T mobile'}";
        Mockito.when(itemDetailsService.saveItemDetails(Mockito.any(Item.class))).thenReturn(item);

        given(itemDetailsService.saveItemDetails(item)).willReturn(item);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/cosomos/items/").content(expectedJson).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
        assertEquals("Item Saved Successfully",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void updateItemDetailsTest() throws Exception {

        Item item = buildItem();
        String inputItemDetails = "{'id': 1,'name': 'OnePlus6T';'description': 'One plus 6T mobile updated'}";
        Mockito.when(itemDetailsService.saveItemDetails(Mockito.any(Item.class))).thenReturn(item);

        given(itemDetailsService.saveItemDetails(item)).willReturn(item);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/cosomos/items/").content(inputItemDetails).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_VALUE);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
        assertEquals("Item updated Successfully",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deleteItemDetailsTest() throws Exception {
        Mockito.doNothing().when(itemDetailsService).deleteItemDetails(Mockito.anyInt());

        given(itemDetailsService.getItemDetails(1)).willReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/cosomos/items/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        assertEquals(HttpStatus.NO_CONTENT.value(),mvcResult.getResponse().getStatus());
    }

    private ItemDetails buildItemDetails() {
        ItemDetails item = new ItemDetails(1,"OnePlus6T","One plus 6T mobile");
        return item;
    }

    private Item buildItem() {
        Item item = new Item(1,"OnePlus6T","One plus 6T mobile");
        return item;
    }

}