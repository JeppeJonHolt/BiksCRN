/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class ACycleOption extends POption
{
    private TTCycle _tCycle_;

    public ACycleOption()
    {
        // Constructor
    }

    public ACycleOption(
        @SuppressWarnings("hiding") TTCycle _tCycle_)
    {
        // Constructor
        setTCycle(_tCycle_);

    }

    @Override
    public Object clone()
    {
        return new ACycleOption(
            cloneNode(this._tCycle_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACycleOption(this);
    }

    public TTCycle getTCycle()
    {
        return this._tCycle_;
    }

    public void setTCycle(TTCycle node)
    {
        if(this._tCycle_ != null)
        {
            this._tCycle_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tCycle_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tCycle_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tCycle_ == child)
        {
            this._tCycle_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tCycle_ == oldChild)
        {
            setTCycle((TTCycle) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
