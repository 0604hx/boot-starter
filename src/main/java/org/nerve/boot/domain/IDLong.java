package org.nerve.boot.domain;

abstract public class IDLong implements ID<Long> {

    protected long id;

    @Override
    public Long id() {
        return id;
    }

    public Long getId(){
        return id;
    }

    public IDLong setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean using() {
        return id>0;
    }
}
