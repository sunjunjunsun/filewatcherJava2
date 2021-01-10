package com.sunjun;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;


public class WatchDir {
 
    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;
    private final boolean subDir;
 
    
    
    public WatchDir(File file, boolean subDir, FileActionCallback callback) throws Exception {
        if (!file.isDirectory())
            throw new Exception(file.getAbsolutePath() );
 
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey, Path>();
        this.subDir = subDir;
        Path dir = Paths.get(file.getAbsolutePath());
        if (subDir) {
            registerAll(dir);
        } else {
            register(dir);
        }
        processEvents(callback);
    }
 
    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }
 
    
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        keys.put(key, dir);
    }
 
    
    private void registerAll(final Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
 
    
    @SuppressWarnings("rawtypes")
    void processEvents(FileActionCallback callback) {
        for (;;) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
            Path dir = keys.get(key);
            if (dir == null) {
               
                continue;
            }
 
            for (WatchEvent<?> event : key.pollEvents()) {
                Kind kind = event.kind();
 
                
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
 
              
                WatchEvent<Path> ev = cast(event);
                Path name = ev.context();
                Path child = dir.resolve(name);
                File file = child.toFile();
                if (kind.name().equals("ENTRY_DELETE")) {
                    callback.delete(file);
                } else if (kind.name().equals("ENTRY_CREATE")) {
                    callback.create(file);
                } else if (kind.name().equals("ENTRY_MODIFY")) {
                    callback.modify(file);
                } else {
                    continue;
                }
 
                if (subDir && (kind == StandardWatchEventKinds.ENTRY_CREATE)) {
                    try {
                        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                            registerAll(child);
                        }
                    } catch (IOException x) {
                    	
                    }
                }
            }
 
            boolean valid = key.reset();
            if (!valid) {
              
                keys.remove(key);
              
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
 
}
