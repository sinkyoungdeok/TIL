import {BaseEntity, Column, Entity, PrimaryGeneratedColumn} from "typeorm";
import {BoardStatus} from "./board-status.enum.model";

@Entity()
export class Board extends BaseEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  title: string;

  @Column()
  description: string;

  @Column()
  status: BoardStatus;
}