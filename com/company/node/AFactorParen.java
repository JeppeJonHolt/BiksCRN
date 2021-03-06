/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class AFactorParen extends PParen
{
    private PPolarity _polarity_;

    public AFactorParen()
    {
        // Constructor
    }

    public AFactorParen(
        @SuppressWarnings("hiding") PPolarity _polarity_)
    {
        // Constructor
        setPolarity(_polarity_);

    }

    @Override
    public Object clone()
    {
        return new AFactorParen(
            cloneNode(this._polarity_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFactorParen(this);
    }

    public PPolarity getPolarity()
    {
        return this._polarity_;
    }

    public void setPolarity(PPolarity node)
    {
        if(this._polarity_ != null)
        {
            this._polarity_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._polarity_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._polarity_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._polarity_ == child)
        {
            this._polarity_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._polarity_ == oldChild)
        {
            setPolarity((PPolarity) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
