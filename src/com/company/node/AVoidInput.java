/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class AVoidInput extends PInput
{
    private TTVoiddcl _tVoiddcl_;

    public AVoidInput()
    {
        // Constructor
    }

    public AVoidInput(
        @SuppressWarnings("hiding") TTVoiddcl _tVoiddcl_)
    {
        // Constructor
        setTVoiddcl(_tVoiddcl_);

    }

    @Override
    public Object clone()
    {
        return new AVoidInput(
            cloneNode(this._tVoiddcl_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVoidInput(this);
    }

    public TTVoiddcl getTVoiddcl()
    {
        return this._tVoiddcl_;
    }

    public void setTVoiddcl(TTVoiddcl node)
    {
        if(this._tVoiddcl_ != null)
        {
            this._tVoiddcl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tVoiddcl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tVoiddcl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tVoiddcl_ == child)
        {
            this._tVoiddcl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tVoiddcl_ == oldChild)
        {
            setTVoiddcl((TTVoiddcl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
