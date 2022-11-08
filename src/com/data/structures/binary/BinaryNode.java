package com.data.structures.binary;

import lombok.Data;

@Data
public class BinaryNode {
    private Integer data;
    private BinaryNode leftNode;
    private BinaryNode righNode;


    public BinaryNode(Integer data) {
        this.data = data;
    }
}
