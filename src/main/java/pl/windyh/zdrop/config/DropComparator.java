package pl.windyh.zdrop.config;

import pl.windyh.zdrop.models.DropGroup;

import java.util.Comparator;

public class DropComparator implements Comparator<DropGroup> {

    @Override
    public int compare(DropGroup o1, DropGroup o2) {
        return o2.getPriority()-o1.getPriority();
    }
}
