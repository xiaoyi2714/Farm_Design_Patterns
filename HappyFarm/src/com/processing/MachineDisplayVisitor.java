package com.processing;

public class MachineDisplayVisitor implements MachineVisitor {
    @Override
    public void visit(Machine machine) {
        machine.setState(0);
        System.out.println("通过访问者维修机器成功");
    }
}
