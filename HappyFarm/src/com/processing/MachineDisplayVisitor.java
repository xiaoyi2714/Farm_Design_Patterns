package com.processing;

public class MachineDisplayVisitor implements MachineVisitor {
    @Override
    public void visit(Machine machine) {
        machine.setState(0);
        System.out.println("Successfully repair the machine through the visitor.");
    }
}
