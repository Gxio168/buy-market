package cn.bugstack.types.design.framework.tree;

public interface StrategyHandler<T, D, R> {
    StrategyHandler DEFAULT = (requestParameter, dynamicContext) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;
}
