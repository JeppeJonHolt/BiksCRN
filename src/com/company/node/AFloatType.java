/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class AFloatType extends PType
{
    private TTFloatType _tFloatType_;

    public AFloatType()
    {
        // Constructor
    }

    public AFloatType(
        @SuppressWarnings("hiding") TTFloatType _tFloatType_)
    {
        // Constructor
        setTFloatType(_tFloatType_);

    }

    @Override
    public Object clone()
    {
        return new AFloatType(
            cloneNode(this._tFloatType_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFloatType(this);
    }

    public TTFloatType getTFloatType()
    {
        return this._tFloatType_;
    }

    public void setTFloatType(TTFloatType node)
    {
        if(this._tFloatType_ != null)
        {
            this._tFloatType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tFloatType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tFloatType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tFloatType_ == child)
        {
            this._tFloatType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tFloatType_ == oldChild)
        {
            setTFloatType((TTFloatType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
