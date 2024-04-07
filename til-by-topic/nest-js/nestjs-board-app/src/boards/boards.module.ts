import { Module } from '@nestjs/common';
import { BoardsController } from './boards.controller';
import { BoardsService } from './boards.service';
import {TypeOrmModule} from "@nestjs/typeorm";
import {BoardRepository} from "./board.repository";

@Module({
  imports: [
      TypeOrmModule.forFeature([BoardRepository])
  ],
  controllers: [BoardsController],
  providers: [BoardsService],
})
export class BoardsModule {}
