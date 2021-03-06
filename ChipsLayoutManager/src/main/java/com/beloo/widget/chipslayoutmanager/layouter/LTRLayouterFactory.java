package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.breaker.IRowBreaker;
import com.beloo.widget.chipslayoutmanager.cache.IViewCacheStorage;

public class LTRLayouterFactory extends AbstractLayouterFactory {

    public LTRLayouterFactory(ChipsLayoutManager layoutManager, IViewCacheStorage cacheStorage, IRowBreaker breaker) {
        super(layoutManager, cacheStorage, breaker);
    }

    @Override
    Rect createOffsetRectForUpLayouter(Rect anchorRect) {
        return new Rect(
                0,
                anchorRect == null ? layoutManager.getPaddingTop() : anchorRect.top,
                //we shouldn't include anchor view here, so anchorLeft is a rightOffset
                anchorRect == null ? layoutManager.getPaddingRight() : anchorRect.left,
                anchorRect == null ? layoutManager.getPaddingBottom() : anchorRect.bottom);
    }

    @Override
    Rect createOffsetRectForDownLayouter(Rect anchorRect) {
        return new Rect(
                //we should include anchor view here, so anchorLeft is a leftOffset
                anchorRect == null ? layoutManager.getPaddingLeft() : anchorRect.left,
                anchorRect == null ? layoutManager.getPaddingTop() : anchorRect.top,
                0,
                anchorRect == null ? layoutManager.getPaddingBottom() : anchorRect.bottom);
    }

    @Override
    AbstractLayouter.Builder createUpBuilder() {
        return LTRUpLayouter.newBuilder();
    }

    @Override
    AbstractLayouter.Builder createDownBuilder() {
        return LTRDownLayouter.newBuilder();
    }
}
