package com.example.FakeStrore.DTO.fakeStroreDTOs;

import com.example.FakeStrore.DTO.ProductQuantityDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartResponseDTO {
    private int id;
    private int userId;
    private String date;
    private List<ProductQuantityDTO> products;
    private int __v ;
}
