package com.peygreatz.store.connection.callbacks;

import com.peygreatz.store.model.Product;

import java.io.Serializable;

public class CallbackProductDetails implements Serializable {

    public String status = "";
    public Product product = null;

}
