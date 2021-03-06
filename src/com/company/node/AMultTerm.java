/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.node;

import com.company.analysis.*;

@SuppressWarnings("nls")
public final class AMultTerm extends PTerm
{
    private PPower _power_;
    private TTMult _tMult_;
    private PTerm _term_;

    public AMultTerm()
    {
        // Constructor
    }

    public AMultTerm(
        @SuppressWarnings("hiding") PPower _power_,
        @SuppressWarnings("hiding") TTMult _tMult_,
        @SuppressWarnings("hiding") PTerm _term_)
    {
        // Constructor
        setPower(_power_);

        setTMult(_tMult_);

        setTerm(_term_);

    }

    @Override
    public Object clone()
    {
        return new AMultTerm(
            cloneNode(this._power_),
            cloneNode(this._tMult_),
            cloneNode(this._term_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultTerm(this);
    }

    public PPower getPower()
    {
        return this._power_;
    }

    public void setPower(PPower node)
    {
        if(this._power_ != null)
        {
            this._power_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._power_ = node;
    }

    public TTMult getTMult()
    {
        return this._tMult_;
    }

    public void setTMult(TTMult node)
    {
        if(this._tMult_ != null)
        {
            this._tMult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tMult_ = node;
    }

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._power_)
            + toString(this._tMult_)
            + toString(this._term_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._power_ == child)
        {
            this._power_ = null;
            return;
        }

        if(this._tMult_ == child)
        {
            this._tMult_ = null;
            return;
        }

        if(this._term_ == child)
        {
            this._term_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._power_ == oldChild)
        {
            setPower((PPower) newChild);
            return;
        }

        if(this._tMult_ == oldChild)
        {
            setTMult((TTMult) newChild);
            return;
        }

        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
