package com.mycompany.biz.scraw;

import java.util.function.BiConsumer;
import java.util.function.Function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSetMethodWrap<T,K>{
    Function<? super T, K> destGetMethod;
    BiConsumer<T, K> destSetMethod;
    
    public GetSetMethodWrap(Function<? super T, K> destGetMethod, BiConsumer<T, K> destSetMethod) {
        super();
        this.destGetMethod = destGetMethod;
        this.destSetMethod = destSetMethod;
    }

}