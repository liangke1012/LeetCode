package leetcode.shejilei;

import java.util.*;

public class ThroneInheritance {
    Map<String, List<String>> map;
    Set<String> deads;
    String king;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        deads = new HashSet<>();
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = map.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        map.put(parentName,children);
    }

    public void death(String name) {
        deads.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preorder(ans, king);
        return ans;
    }

    private void preorder(List<String> ans, String name) {
        if ( !deads.contains(name)) {
            ans.add(name);
        }
        List<String> children = map.getOrDefault(name, new ArrayList<>());
        for (String childName : children) {
            preorder(ans, childName);
        }
    }
}
