/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class ASampleinitSample extends PSample
{
    private TTSampledcl _tSampledcl_;
    private TTString _tString_;
    private PSamplefunc _samplefunc_;

    public ASampleinitSample()
    {
        // Constructor
    }

    public ASampleinitSample(
        @SuppressWarnings("hiding") TTSampledcl _tSampledcl_,
        @SuppressWarnings("hiding") TTString _tString_,
        @SuppressWarnings("hiding") PSamplefunc _samplefunc_)
    {
        // Constructor
        setTSampledcl(_tSampledcl_);

        setTString(_tString_);

        setSamplefunc(_samplefunc_);

    }

    @Override
    public Object clone()
    {
        return new ASampleinitSample(
            cloneNode(this._tSampledcl_),
            cloneNode(this._tString_),
            cloneNode(this._samplefunc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASampleinitSample(this);
    }

    public TTSampledcl getTSampledcl()
    {
        return this._tSampledcl_;
    }

    public void setTSampledcl(TTSampledcl node)
    {
        if(this._tSampledcl_ != null)
        {
            this._tSampledcl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tSampledcl_ = node;
    }

    public TTString getTString()
    {
        return this._tString_;
    }

    public void setTString(TTString node)
    {
        if(this._tString_ != null)
        {
            this._tString_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tString_ = node;
    }

    public PSamplefunc getSamplefunc()
    {
        return this._samplefunc_;
    }

    public void setSamplefunc(PSamplefunc node)
    {
        if(this._samplefunc_ != null)
        {
            this._samplefunc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._samplefunc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tSampledcl_)
            + toString(this._tString_)
            + toString(this._samplefunc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tSampledcl_ == child)
        {
            this._tSampledcl_ = null;
            return;
        }

        if(this._tString_ == child)
        {
            this._tString_ = null;
            return;
        }

        if(this._samplefunc_ == child)
        {
            this._samplefunc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tSampledcl_ == oldChild)
        {
            setTSampledcl((TTSampledcl) newChild);
            return;
        }

        if(this._tString_ == oldChild)
        {
            setTString((TTString) newChild);
            return;
        }

        if(this._samplefunc_ == oldChild)
        {
            setSamplefunc((PSamplefunc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
