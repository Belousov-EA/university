package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser.NumberType;

public interface TreeNode {
    JsonToken asToken();

    NumberType numberType();

    JsonParser traverse();
}
