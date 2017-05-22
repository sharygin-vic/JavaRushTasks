package com.javarush.task.task27.task2712.ad;

/**
 * Created by dell on 17-May-17.
 */
public class Advertisement {
    private Object content;                 //видео
    private String name;                    //имя/название
    private long initialAmount;             //начальная сумма, стоимость рекламы в копейках
    private int hits;                       //количество оплаченных показов
    private int duration;                   //продолжительность в секундах
    private long amountPerOneDisplaying;    //стоимости одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits < 1 ? 0 : (long)(((double)initialAmount) / hits);
    }


    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits < 1) {
            throw new UnsupportedOperationException();
        }
        if (hits == 1) {
            amountPerOneDisplaying += (initialAmount % amountPerOneDisplaying);
        }
        hits--;
    }

    public int getHits() {
        return hits;
    }



}
